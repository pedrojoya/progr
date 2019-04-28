package es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animal;

import es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animalvisitor.AnimalVisitor;

// Un animal es también un visitante de otro animal, ya que puede interactuar
// con él, de ahí que implemente AnimalVisitor.
    public abstract class Animal implements AnimalVisitor {

        private final String name;

        Animal(String name) {
            this.name = name;
        }

        @SuppressWarnings("WeakerAccess")
        public String getName() {
            return name;
        }

        // Este método debe ser abstracto forzosamente. No puede ser concreto
        // porque al usar el visitor.visit(this) el compilador forzaría
        // a que AnimalVisitor tuviera el método visit(Animal receiver), que
        // es precisamente lo que queremos evitar.
        public abstract void accept(AnimalVisitor visitor);

}
