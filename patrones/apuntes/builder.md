# Patrón de diseño Builder

------

[TOC]

------

## Problema que queremos resolver

Cuando queremos construir un objeto de un clase compuesto internamente por numerosas partes distintas, algunas de ellas opcionales. 

Opcionalmente, queremos que la construcción del objeto a partir de sus partes sea transparente de cara al cliente.

## Definición

El patrón de diseño **Builder** es un patrón de diseño para creación de objetos (*creational*), ideal para gestionar la construcción de objetos con las siguientes características:

* Cuando la construcción del objeto es **compleja porque puede tener muchos parámetros, correspondientes a las partes del objeto, algunas de ellas opcionales**.
* Cuando queremos que nuestro objeto sea **inmutable** una vez haya sido creado.
* Cuando queramos que la construcción del objeto a partir de sus clases sea transparente al cliente.

Cuando una clase tiene diversas combinaciones de parámetros opcionales, tenemos dos opciones principales a la hora de construir objetos de dicha clases:

- Proporcionar un constructor sólo con los parámetros obligatorios y los métodos *setters* para establecer posteriormente los parámetros opcionales. Esta opción tiene el inconveniente de que el objeto no puede ser inmutable, dado que debemos proporcionar los métodos *setters*.
- Proporcionar numerosos constructores, tantos como combinaciones de parámetros opcionales podamos tener y no proporcionar métodos *setters*. Tiene la ventaja frente a la técnica anterior de que los objetos creados serán inmutables, ya que no proporcionamos *setters*, pero tiene el gran inconveniente de que hay que crear números constructores con muchos parámetros (conocidos como *telescoping constructors*), y que debemos decidir qué constructor usar en cada caso.

El patrón **Builder** viene a mejorar las dos técnicas anteriores, mediante la delegación de la responsabilidad de la constructor del objeto a otro objeto especializado, denominado *builder* (constructor). 

Los participantes en este patrón de diseño son:

- El **producto** (*product*): Corresponde al modelo del objeto que se quiere crear. Se implementa como una clase concreta.
- El **constructor** (*builder*): Define uno o más métodos abstractos que permitan especificar cómo se quiere construir las distintas partes del objeto (*buildPart()*). Además proporciona un método abstracto *getResult()* o *build()* que devuelve el producto una vez construido. Se implementa normalmente como una clase abstracta con métodos abstractos, o como una interfaz.
- Los **constructores concretos** (*concrete builders*): Corresponde a una o varias implementaciones concretas del constructor. Se implementan como clases concretas que heredan de la clase constructor, por lo que están obligados a implementar los métodos *buildPart()* que permiten construir las distintas partes del objeto, así como el método *getResult()* o *build()* que construye y retorna el producto.
- El **director** (*director*): Posee una instancia del constructor, en forma de instancia de alguno de los constructores concretos. Proporciona un método *construct(type)* mediante el que el cliente puede solicitar al director la creación del un producto con unas características concretas. El cometido de este método es dirigir la construcción del objeto, llamando a los distintos métodos *buildPart()* del constructor pasándole los parámetros adecuados para dicho tipo de producto, para indicar al constructor cómo debe construir el producto. Finalmente se llamará al método *getResult()* o *build()* del constructor para obtener el producto. El director es el encargado de hacer transparente al cliente la construcción del producto, ya que el cliente tan sólo llamará al método *construct(type)* del director.

Este patrón es implementado a menudo con clases proporcionadas por el *framework* o librerías que estemos usando.

## Diseño

El funcionamiento es el siguiente: el "cliente" le pedirá al director que construya un producto, para lo que el director llamará a distintos métodos del constructor para indicar cómo deben construirse la distintas partes del producto. Finalmente, el director le indicará al constructor que construya y retorne el producto, que el director entregará a su vez al cliente.

La ventaja principal de este patrón es que el objeto producto construido puede ser inmutable, si no proporcionamos métodos *setters* a la clase producto. Por otra parte, podemos hacer que el constructor de dicha clase sea privado, y crear la clase Builder como clase interna de la clase Producto. si queremos forzar a que sólo se puedan crear objetos producto a través de un objeto Builder. 

Veamos el diagrama UML:

![Diagrama UML del patrón Builder](files/builder.svg)

## Ejemplo

Vamos a implementar la construcción de objetos `Sandwich` a través del patrón *builder*. Debemos tener en cuenta que un sandwich está formado por la siguientes partes: el pan, la carne (si lleva), cero o más condimentos (si lleva) y la salsa (si lleva), pero sólo el pan es obligatorio.

El primer paso es crear el producto, en este caso la clase `Sandwich`. Con el objetivo de que los sandwich sean inmutables una vez construidos, no se crean *setters* en la clase. Además, para que los montaditos sólo puedan ser creados a través del *builder*, el constructor se define como privado y la clase `Builder` se crea como una clase interna de la clase `Sandwich`. 

```java
public class Sandwich {

    // Sandwich is inmutable
    private final String style;
    private final String name;
    private final Bread bread;
    private final Meat meat;
    private final List<Condiment> condiments;
    private final Sauce sauce;

		// Getters.
 		... 
  
    // Private, so it can only be used from the static inner Builder class.
    private Sandwich(Builder builder) {
        this.style = builder.style;
        this.name = builder.name;
        this.bread = builder.bread;
        this.meat = builder.meat;
        this.condiments = new ArrayList<>(builder.condiments);
        this.sauce = builder.sauce;
    }
  
  	// ...

}
```

El siguiente paso es crear como clase interna de `Sandwich` una clase abstracta, llamada `Builder` que represente un *builder* abstracto de sandwiches. El *builder* proporcionará una serie de métodos abstractos que permitan construir los distintos ingredientes o partes un sandwich, y un método que construya un objeto `Sandwich` con dichos ingredientes. 

El método que construye los objetos `Sandwich` debe validar que todos los ingredientes obligatorios han sido establecidos en el *builder*. Opcionalmente, una vez construido el sandwich podemos llamar a un método que resetee los campos del builder, para que pueda ser reutilizado para construir otro sandwich.

```java
public class Sandwich {

    // ... 

    public abstract static class Builder {

        protected final String style;
        protected String name;
        protected Bread bread;
        protected Meat meat;
        protected List<Condiment> condiments = new ArrayList<>();
        protected Sauce sauce;

        public Builder(String style) {
            this.style = style;
        }

        // These methods return the builder to allow fluid syntax
        public abstract Builder setName(String name);
        public abstract Builder setBread(Bread bread);
        public abstract Builder setMeat(Meat meat);
        public abstract Builder addCondiment(Condiment condiment);
        public abstract Builder setSauce(Sauce sauce);

        public Sandwich build() {
            validateMandatoryFields();
            Sandwich sandwich = new Sandwich(this);
            reset();
            return sandwich;
        }

        private void validateMandatoryFields() {
            if (name == null || name.isEmpty()) 
              	throw new IllegalStateException("Name is mandatory");
            if (bread == null) 
              	throw new IllegalStateException("Bread is mandatory");
        }
      
        public void reset() {
            name = null;
            meat = null;
            condiments.clear();
            sauce = null;
        }

    }

}
```

La clase anterior ha sido creada abstracta con el objetivo de hacer más versátil la creación de los sandwiches a través del patrón *builder*, ya que podremos crear uno o más implementaciones concretas del *builder* que podremos especificar, e incluso intercambiar, en tiempo de ejecución, para construir sandwiches con el estilo de distintos bares. Por ejemplo, la forma exacta en la que se construyen los sandwiches en un bar no coincide al cien por cien con como se construyen en otro bar. En nuestro ejemplo vamos a crear dos clases concretas correspondientes a dos implementaciones distintas de la clase abstracta `Sandwich.Builder`, una para cada tipo de bar con el que trabaja la aplicación:

```java
public class GambrinusSandwichBuilder extends Sandwich.Builder {

    private static final String STYLE = "Gambrinus";

    public GambrinusSandwichBuilder() {
        super(STYLE);
    }


    @Override
    public Sandwich.Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Sandwich.Builder setBread(Bread bread) {
        this.bread = bread;
      	// In Grambrinus's they put sesame seed on every bread. 
        condiments.add(new Condiment("semillas de sésamo"));
        return this;
    }

    @Override
    public Sandwich.Builder setMeat(Meat meat) {
        this.meat = meat;
        return this;
    }

    @Override
    public Sandwich.Builder addCondiment(Condiment condiment) {
        this.condiments.add(condiment);
        return this;
    }

    @Override
    public Sandwich.Builder setSauce(Sauce sauce) {
        this.sauce = sauce;
        // This is Gambrinu's secret ingrendient. If the sandwich has sauces
      	// then they add pepper.
        this.condiments.add(new Condiment("pimienta"));
        return this;
    }
    
}
```

```java
public class LaCasitaSandwichBuilder extends Sandwich.Builder {

    private static final String LA_CASITA_STYLE = "La Casita";

    public LaCasitaSandwichBuilder() {
        super(LA_CASITA_STYLE);
    }

    @Override
    public Sandwich.Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Sandwich.Builder setBread(Bread bread) {
        this.bread = bread;
        return this;
    }

    @Override
    public Sandwich.Builder setMeat(Meat meat) {
        this.meat = meat;
        return this;
    }

    @Override
    public Sandwich.Builder addCondiment(Condiment condiment) {
        this.condiments.add(condiment);
        // La Casita always adds double amount of condiment
        this.condiments.add(condiment);
        return this;
    }

    @Override
    public Sandwich.Builder setSauce(Sauce sauce) {
        this.sauce = sauce;
        return this;
    }

}
```

También crearemos el director, que es quién recibe las peticiones del cliente dependiendo del tipo de sandwich que quiere y usa un *builder* para construir las distintas partes del sandwich y finalmente construir y retornar el montadito en sí. De esta manera el cliente no debe conocer exactamente cómo se construye un determinado tipo de sandwich en el bar correspondiente.

El director (algo así como la cocina del bar) trabaja con tipos de sandwiches estándar (los que están en su carta), por lo que definimos un el enum `SandwichType`:

```java
public enum SandwichType {
    SERRANITO,
    HIGADO,
    CATALAN
}
```

El director proporciona un método al cliente para que pida los sandwiches, indicando el tipo de sanwich que desea (de entre los de la carta).

```java
public class SandwichDirector {

    private final Sandwich.Builder builder;

    public SandwichDirector(Sandwich.Builder builder) {
        this.builder = builder;
    }

    public Sandwich buildSandwich(SandwichType sandwichType) {
        switch (sandwichType) {
            case SERRANITO:
                return builder
                        .setName("Serranito")
                        .setBread(new Bread("pulguita"))
                        .setMeat(new Meat("lomo"))
                        .addCondiment(new Condiment("pimiento"))
                        .addCondiment(new Condiment("jamón"))
                        .build();
            case HIGADO:
                return builder
                        .setName("Higado")
                        .setBread(new Bread("pulguita"))
                        .setMeat(new Meat("higado"))
                        .addCondiment(new Condiment("tocino"))
                        .build();
            case CATALAN:
                return builder
                        .setName("Catalan")
                        .setBread(new Bread("tosta"))
                        .addCondiment(new Condiment("jamón"))
                        .addCondiment(new Condiment("tomate"))
                        .setSauce(new Sauce("aceite"))
                        .build();
            default:
                throw new RuntimeException("Tipo de sandwich desconocido");
        }
    }

}
```

Finalmente el cliente no tiene más que obtener una instancia del director y hacerle los pedidos:

```java
public class Main {

    public static void main(String[] args) {
        SandwichDirector director = new SandwichDirector(new GambrinusSandwichBuilder());

        Sandwich serranito = director.buildSandwich(SandwichType.SERRANITO);
        Sandwich higado = director.buildSandwich(SandwichType.HIGADO);
        Sandwich catalan = director.buildSandwich(SandwichType.CATALAN);
        System.out.println("Sandwich Serranito - " + serranito);
        System.out.println("Sandwich Hígado - " + higado);
        System.out.println("Sandwich Catalán - " + catalan);
    }

}
```

## Implementación simplificada

Existen distintas maneras de implementar el patrón de diseño Builder. La forma más simplificada consiste en:

* Hacer que el propio cliente haga las veces de director, es decir, que sea quién llame a los distintos métodos del constructor para indicarle cómo se deben crear las distintas partes del producto. Evidentemente, en este caso, la construcción del producto ya no es transparente al cliente.
* Crear un único tipo de builder concreto, con lo que nos ahorramos la clase abstracta Builder y el cliente se comunica directamente con una instancia del único tipo de builder concreto existente.
* Aunque no es estrictamente necesario, en muchas ocasiones la clase correspondiente al único tipo de builder concreto se crea como una clase estática interna de la clase producto.

Java implementa este patrón en varias clases, como `StringBuilder`, `DocumentBuilder` o `Locale.Builder`.

## Ejemplo de implementación simplificada

Vamos a construir una clase `Sandwich`, siguiendo el patrón de diseño builder simplificado, ya que implementamos directamente un único *concrete builder* como clase interna estática de la clase `Sandwich`.

```java
public class Sandwich {

    // Sandwich is inmutable
    private final String style;
    private final String name;
    private final Bread bread;
    private final Meat meat;
    private final List<Condiment> condiments;
    private final Sauce sauce;

  	// Getters
  	// ...

  	// Private, so it can only be used from the static inner builder.
    private Sandwich(Builder builder) {
        this.style = builder.style;
        this.name = builder.name;
        this.bread = builder.bread;
        this.meat = builder.meat;
        this.condiments = new ArrayList<>(builder.condiments);
        this.sauce = builder.sauce;
    }

		// ...
    
  	public static class Builder {

        private final String style;
        private final String name;
        private final Bread bread;
        private Meat meat;
        private final List<Condiment> condiments = new ArrayList<>();
        private Sauce sauce;

        public Builder(String style, String name, Bread bread) {
            this.style = style;
            this.name = name;
            this.bread = bread;
        }

        public Builder setMeat(Meat meat) {
            this.meat = meat;
            return this;
        }

        public Builder addCondiment(Condiment condiment) {
            condiments.add(condiment);
            return this;
        }

        public Builder setSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public Sandwich build() {
            return new Sandwich(this);
        }

    }

}
```

El cliente simplemente obtendrá las instancias que desee del *builder* y construirá los montaditos a su gusto (en este caso se está reusando el mismo builder, ya que al construir un sandwich se resetea el builder:

```java
public class Main {

    public static void main(String[] args) {
        // We use a diferent builder for each sandwich.
        Sandwich serranito = 
          new Sandwich.Builder("Estilo propio", "Serranito", new Bread("pulguita"))
                .setMeat(new Meat("lomo"))
                .addCondiment(new Condiment("pimiento"))
                .addCondiment(new Condiment("jamón"))
                .build();
        Sandwich higado = 
          new Sandwich.Builder("Estilo propio", "Higado", new Bread("pulguita"))
                .setMeat(new Meat("higado"))
                .addCondiment(new Condiment("tocino"))
                .build();
        Sandwich catalan = 
          new Sandwich.Builder("Estilo propio", "Catalan", new Bread("tosta"))
                .addCondiment(new Condiment("jamón"))
                .addCondiment(new Condiment("tomate"))
                .setSauce(new Sauce("aceite"))
                .build();
        System.out.println("Sandwich Serranito - " + serranito);
        System.out.println("Sandwich Hígado - " + higado);
        System.out.println("Sandwich Catalán - " + catalan);
    }

}
```

## Puntos débiles

* Es algo más complejo que la creación de un simple constructor, por lo que debemos emplearlo cuando el constructor tenga varios parámetros (4 o más).
* Algunos programadores no están acostumbrados al empleo de la sintaxis fluida (*fluent syntax*) proporcionada por el hecho de que los métodos *setters* del objeto *builder* retornen el propio objeto *builder*.

## Diferencias con el patrón Prototype

* No necesita el empleo de una interfaz, aunque es posible usarla.
* Es fácil ampliar su funcionalidad manteniendo la compatibilidad con versiones anteriores, mientras que en el patrón Prototype esto es más complejo, dado que se implementa a partir de la clonación de la memoria de los objetos.
* Mientras que el patrón Builder trata de gestionar constructores complejos, el patrón Prototype precisamente trata de evitar llamar a los constructores. Su enfoque es justo el contrario.


## Diferencias con el patrón Factory

* El patrón Builder permite la construcción de objetos en distintos pasos con distintas variaciones, a diferencia de en el patrón Factory, donde la construcción se realiza en un único paso.
* El patrón Builder está especializado en la construcción de instancias de una determinada clase, mientras que el patron Factory está especializado en la construcción de instancia de una determinada jerarquía de clases (subtipos de un tipo abstracto).
* En el caso de versión simplificado del patrón Builder, la construcción de objetos requiere por parte del cliente de un mayor conocimiento de la lógica de negocio, en comparación con el patrón Factory.