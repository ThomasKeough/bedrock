package use_cases.swap;

public interface SwapOutputBoundary {
    public void prepareSuccessView(SwapOutputData swapOutputData);
    public void prepareFailView(SwapOutputData swapOutputData);

}