public class AnalysisDecorator extends AssessmentDecorator{
    public AnalysisDecorator(Assessment decoratedAssessment) {
        super(decoratedAssessment);
    }

    @Override
    public void addTask(Task task) {
        decoratedAssessment.addTask(task);
    }

    @Override
    public int calculateFee() {
        return decoratedAssessment.calculateFee() + new Analysis().getFee();
    }
}
