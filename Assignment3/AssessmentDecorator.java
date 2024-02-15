import java.util.ArrayList;

public abstract class AssessmentDecorator implements Assessment{
    protected Assessment decoratedAssessment;
    protected ArrayList<Task> additionalTasks;

    public AssessmentDecorator(Assessment decoratedAssessment) {
        this.decoratedAssessment = decoratedAssessment;
        this.additionalTasks = new ArrayList<>();
    }

    @Override
    public int calculateFee() {
        return decoratedAssessment.calculateFee();
    }
}
