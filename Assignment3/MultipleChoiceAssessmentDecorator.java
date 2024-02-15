public class MultipleChoiceAssessmentDecorator extends AssessmentDecorator {

    public MultipleChoiceAssessmentDecorator(Assessment decoratedAssessment) {
        super(decoratedAssessment);
    }

    @Override
    public void addTask(Task task) {
        decoratedAssessment.addTask(task);
        additionalTasks.add(task);
    }

    @Override
    public int calculateFee() {
        int totalFee = decoratedAssessment.calculateFee();
        for (Task task : additionalTasks) {
            totalFee += task.getFee();
        }
        return totalFee;
    }
}
