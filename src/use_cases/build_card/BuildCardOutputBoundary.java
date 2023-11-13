package use_cases.build_card;

public interface BuildCardOutputBoundary {
    void prepareSuccessView(BuildCardOutputData card);
    void prepareFailView(String error);
}
