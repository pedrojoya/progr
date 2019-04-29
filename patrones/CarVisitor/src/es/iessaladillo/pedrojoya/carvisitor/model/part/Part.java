package es.iessaladillo.pedrojoya.carvisitor.model.part;

public abstract class Part implements Visitable {

    private final String description;

    Part(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
