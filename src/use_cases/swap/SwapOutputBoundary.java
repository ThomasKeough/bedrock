package use_cases.swap;

public interface SwapOutputBoundary {
    public void prepareSucessView(SwapOutputData swapOutputData);
    public void prepareFailView(SwapOutputData swapOutputData);
    }
}