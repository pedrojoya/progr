package es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage;

public abstract class CaffeineBeverage {

    // Se define final para que NO se pueda sobrescribir.
    public final void prepareRecipe() {
        boilWater();
        brew();
        onWaterBoilded();
        pourInCap();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCap() {
        System.out.println("Pouring beverage in cap");
    }

    protected void onWaterBoilded() { }

    protected abstract void brew();

    protected abstract void addCondiments();

}
