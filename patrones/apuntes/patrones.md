# Patrones de diseño

------

[TOC]

------

[Siguiente](http://nicedoc.io/pedrojoya/progr/tree/master/patrones/apuntes/singleton.md)

## Intro

Un **patrón de diseño** es una forma reutilizable de resolver un problema común. Cuando diseñamos una aplicación es muy probable que la estructura de las clases que conforma la solución de tu problema ya haya sido usada por otros desarrolladores, normalmente porque se trate de un problema habitual. Si dicha forma de solucionar el problema además se extrapola, explica y reutiliza en múltiples ámbitos o problemas, entonces nos encontramos ante un patrón de diseño de software.

Los patrones de diseño ofrecen una serie de ventajas a la hora de diseñar software:

- Conforman un amplio catálogo de problemas y soluciones
- Estandarizan la resolución de determinados problemas
- Condensan y simplifican el aprendizaje de las buenas prácticas
- Proporcionan un vocabulario común entre desarrolladores
- Evitan “reinventar la rueda”

Uno de los primeros libros que trató el tema de los patrones de diseño fue el famoso [Design Patterns](http://amzn.to/2jLlbJE) del grupo de autores conocido como el *Gang of Four*: Erich Gamma, Richard Helm, Ralph Johnson y John Vlissides. 

## Patrones creacionales

Son los que facilitan la tarea de creación de nuevos objetos, de tal forma que el proceso de creación pueda ser desacoplado de la implementación del resto del sistema. Se basan en dos conceptos:

- Encapsular el conocimiento acerca de los tipos concretos que nuestro sistema utiliza. Estos patrones normalmente trabajarán con interfaces, por lo que la implementación concreta que utilicemos queda aislada.
- Ocultar cómo estas implementaciones concretas necesitan ser creadas y cómo se combinan entre sí.

Los patrones creacionales más conocidos son:

- **Singleton:** limita a uno el número de instancias posibles de una clase en nuestro programa, y proporciona un acceso global al mismo.
- **Builder**: Separa la creación de un objeto complejo de su estructura, de tal forma que el mismo proceso de construcción nos puede servir para crear representaciones diferentes.
- **Prototype:** Permite la creación de objetos basados en “plantillas”. Un nuevo objeto se crea a partir de la clonación de otro objeto.
- **Factory Method:** Expone un método de creación,  delegando en las subclases la implementación de este método.
- **Abstract Factory**: Nos provee una interfaz que delega la creación de un conjunto de objetos relacionados sin necesidad de especificar en ningún momento cuáles son las implementaciones concretas.

## Patrones estructurales

Son patrones que nos facilitan la modelización de nuestro software **especificando la forma en la que unas clases se relacionan con otras**.

Estos son los patrones estructurales que definió la Gang of Four:

- **Adapter**: Permite a dos clases con diferentes interfaces trabajar entre ellas, a través de un objeto intermedio con el que se comunican e interactúan.
- **Bridge**: Desacopla una abstracción de su implementación, para que las dos puedan evolucionar de forma independiente.
- **Composite**: Facilita la creación de estructuras de objetos en árbol, donde todos los elementos emplean una misma interfaz. Cada uno de ellos puede a su vez contener un listado de esos objetos, o ser el último de esa rama.
- **Decorator**: Permite añadir funcionalidad extra a un objeto (de forma dinámica o estática) sin modificar el comportamiento del resto de objetos del mismo tipo.
- **Facade**: Una facade (o fachada) es un objeto que crea una interfaz simplificada para tratar con otra parte del código más compleja, de tal forma que simplifica y aísla su uso. Un ejemplo podría ser crear una fachada para tratar con una clase de una librería externa.
- **Flyweight**: Una gran cantidad de objetos comparte un mismo objeto con propiedades comunes con el fin de ahorrar memoria.
- **Proxy**: Es una clase que funciona como interfaz hacia cualquier otra cosa: una conexión a Internet, un archivo en disco o cualquier otro recurso que sea costoso o imposible de duplicar.

## Patrones de comportamiento

Los patrones de comportamiento nos ayudan a definir la forma en la que los objetos interactúan entre ellos.

Algunos de los más conocidos (por citar unos pocos) son:

- **Command**: Son objetos que encapsulan una acción y los parámetros que necesitan para ejecutarse.
- **Observer**: Los objetos son capaces de suscribirse a una serie de eventos que otro objeto va a emitir, y serán avisados cuando esto ocurra.
- **Strategy**: Permite la selección del algoritmo que ejecuta cierta acción en tiempo de ejecución.
- **Template Method**: Especifica el esqueleto de un algoritmo, permitiendo a las subclases definir cómo implementan el comportamiento real.

## Referencias

https://www.raywenderlich.com/109843/common-design-patterns-for-android

http://devexperto.com/patrones-de-diseno-software/

https://www.javacodegeeks.com/2015/09/java-design-patterns.html

[https://www.youtube.com/playlist?list=PLF206E906175C7E07](https://www.youtube.com/playlist?list=PLF206E906175C7E07)

[https://www.youtube.com/watch?v=G4mFD16PGMg](https://www.youtube.com/watch?v=G4mFD16PGMg)

http://alexsimo.com/singleton-pattern/

https://dev.to/lovis/gang-of-four-patterns-in-kotlin?utm_content=buffer2b6f6&utm_medium=social&utm_source=twitter.com&utm_campaign=buffer