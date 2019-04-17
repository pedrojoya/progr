# Patrón de diseño Singleton

------

[TOC]

------

## Problema que queremos resolver

Queremos definir una clase de la que sólo sea posible crear una única instancia.

## Definición

Se trata de un patrón de diseño creacional (*creational*) muy usado. Se usa cuando queramos que **sólo se pueda crear una única instancia de una determinada clase**, garantizando el control sobre la creación de dicha instancia.

Un aspecto que debemos tener en cuenta es en qué momento debería crearse dicha instancia única, teniendo dos opciones:

* Crear la instancia directamente al referenciar la clase, lo que se conoce como modo *eager* (ansioso, ávido).
* Crear la instancia solamente en el momento en el que se solicita por primera vez, lo que se conoce como modo *lazy* (perezoso). Se recomienda usar el modo perezoso cuando la creación e la instancia sea costosa en tiempo o en recursos.

Otro aspecto importante es que si nuestra aplicación es multihilo la implementación que hagamos de este patrón debe ser *thread-safe*, es decir que debe funcionar correctamente incluso si simultáneamente se trata de obtener la instancia única de la clase desde distintos hilos de ejecución. 

Además, el concepto de instancia única no encaja muy bien con el concepto de serialización, ya que cuando hacemos que una clase sea serializable haciendo que implemente la interfaz `Serializable`, debemos tener en cuenta que al deserializar una representación de un objeto de una clase se creará un nuevo objeto de la clase, tanto si su constructor es privado como si no, por los que ya no existiría un única instancia de la clase. 

Finalmente, debemos tener en cuenta que usando reflexión es posible acceder desde fuera a nuestro constructor, aunque éste sea privado, por lo que el mecanismo básico de control que estamos usando deja de ser efectivo.

El patrón *Singleton* es un patrón de diseño muy controvertido, ya que se acerca mucho al uso de variables globales, algo que tradicionalmente no ha estado bien visto entre la comunidad de desarrolladores. De hecho algunos piensan que forzar a que sólo se pueda construir una única instancia de una clase es una limitación autoimpuesta que puede afectar a la escalabilidad de la aplicación. Debe quedar claro que lo puede considerarse problemático no es que en un momento dado en nuestra aplicación haya una única instancia de una determinada clase, sino que el diseño de nuestra clase haga imposible en el futuro crear mas instancias de dicha clase si cambian los requerimientos.

Por tanto se recomienda no abusar de este patrón de diseño y usarlo sólo en aquellos casos en los que sea estrictamente necesario que no existe más de una instancia de la clase para su correcto funcionamiento.

Java implementa este patrón de diseño en algunas de sus clases, como `Runtime` o `Logger`.

## Diseño

El diagrama UML que representa este patrón de diseño es muy simple:

![Diagrama UML del patrón Singleton](files/singleton.svg)

Como vemos en el diagrama, la única instancia de la clase que podrá ser creada será almacenada en un **atributo estático de la misma clase**, que normalmente recibe el nombre de `instance` (aunque en el diagrama recibe el nombre de `singleton`).

Por otra parte, **el constructor de la clase se vuelve privado**. El motivo es obvio: debemos prohibir la creación de objetos de esta clase desde fuera de la propia clase, para así poder controlar que no se crea más de una instancia. La propia clase será la responsable de crear la instancia única.

Como consecuencia, debemos proporcionar alguna forma alternativa de obtener desde fuera la única instancia de la clase, para lo que creamos un método estático, normalmente denominado `getInstance()`, que retorna dicha instancia única.

Estrictamente hablando, en el patrón *singleton* el método `getInstance()` no debe recibir ningún argumento. Si lo recibiera, entonces el método `getInstance()` sería en realidad un método factoría de construcción de la instancia única.

Existen distintas formas de implementar el patrón *Singleton* en Java, veamos algunas de ellas:

## Implementación eager thread-safe

Esta implementación consiste básicamente en inicializar el atributo estático `instance` directamente llamando al constructor privado.

```java
public class Singleton {
    
    // La instancia será creada cuando se cargue la clase.
    private static final Singleton instance = new Singleton();
    
    private Singleton() { 
        // ...
    }
    
    public static Singleton getInstance(){
        return instance;
    }
    
}
```

## Implementación lazy thread-safe

Esta implementación consiste en inicializar el atributo estático `instance` a `null` y crear la instancia, llamando al constructor privado, solamente cuando alguien llame al método `getInstance()` y la instancia aún no haya sido creada.

```java
public class Singleton {
    
    private static Singleton instance = null;
    
    private Singleton() {
    	// ...
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            // Hacemos la comprobación thread-safe.
            // Lo hacemos aquí para que sólo sea necesario sincronizar
            // si realmente se debe crear el objeto y no si ya existe.
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
            
        }
        return instance;
    }
        
}
```

## Implementación mediante enum

Esta implementación consiste en definir un `enum` con un único valor:

```java
public enum Singleton {
    INSTANCE;
}
```

Esta es la implementación recomendada en Java, ya que es muy sencilla y además, dadas las características propias de los `enum`, es thread-safe, serializable y no tiene problemas con la reflexión.

## Puntos débiles

* Es usado demasiado a menudo, lo que puede reducir el rendimiento de la aplicación.
* Dado que no proporcionan ninguna interfaz y su constructor es privado, normalmente es difícil hacer un test unitario de esta clase, dado que para los test se suelen crear distintas instancias de prueba de dicha clase.
* Hay que diseñarlo a conciencia para que sea *thread-safe*.
* Algunas veces se confunde con el patrón *Factory*.

## Diferencias con el patrón Factory

* El patrón Factory permite obtener varias instancias de la clase, mientras que con el patrón Singleton sólo se puede obtener una única instancia.
* El patrón Factory proporciona distintos métodos de construcción, mientras que el patrón Singleton ofrece un único método.
* El patrón Factory expone una interfaz mientras que el patrón Singleton no, por lo que es más fácil de testear.
* El patrón Factory se adapta más fácilmente al entorno que el patrón Singleton.