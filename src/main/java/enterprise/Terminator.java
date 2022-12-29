
package enterprise;

public class Terminator {

    private String model;
    private int damage;

    public Terminator(String model, int damage) {

        this.model = model;
        this.damage = damage;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }

    public Terminator copy() {

        return new Terminator(this.getModel(), this.getDamage());
    }

    public void print() {

        System.out.println("Model: " + model + " Damage: " + damage + "%");
    }
}
