package lab.test.secondlab.exam.domain;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 17.06.2017
 */
public class Man {
    // Артур, нервничая, вошел следом и был ошеломлен,
    // увидев развалившегося в кресле человека, положившего ноги на пульт управления

    private boolean lagsOnTheTable;
    private boolean isLyingInArmchair;

    public Man() {
        this.lagsOnTheTable = false;
        this.isLyingInArmchair = false;
    }

    public void sitOnChairInsideRoom() {
        this.isLyingInArmchair = true;
        this.lagsOnTheTable = true;
    }

    public boolean isLagsOnTheTable() {
        return lagsOnTheTable;
    }

    public boolean isLyingInArmchair() {
        return isLyingInArmchair;
    }
}
