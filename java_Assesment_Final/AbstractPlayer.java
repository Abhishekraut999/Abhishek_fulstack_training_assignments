public abstract class AbstractPlayer {
    protected int id;
    protected String name;
    protected String skill;
    protected int experience;
    protected String country;
    protected double overallScore;

    public AbstractPlayer(int id, String name, String skill, int experience, String country, double overallScore) {
        this.id = id;
        this.name = name;
        this.skill = skill;
        this.experience = experience;
        this.country = country;
        this.overallScore = overallScore;
    }
}
