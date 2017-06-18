package lab.test.secondlab.exam.domain;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
public class Arthur {
    // Артур, нервничая, вошел следом и был ошеломлен,
    // увидев развалившегося в кресле человека, положившего ноги на пульт управления

    private boolean isNervous;
    private boolean isStunned;
    private Man manOnChair;

    public Arthur() {
        isNervous = false;
        isStunned = false;
        this.manOnChair = null;
    }

    public boolean isNervous() {
        return isNervous;
    }

    public boolean isStunned() {
        return isStunned;
    }

    public Man getManOnChair() {
        return manOnChair;
    }

    public void goInsideRoom() {
        this.manOnChair = new Man();
        this.isStunned = true;
        this.isNervous = true;
    }
}
