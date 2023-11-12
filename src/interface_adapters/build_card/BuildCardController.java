package interface_adapters.build_card;

import use_cases.build_card.BuildCardInputBoundary;

public class BuildCardController {
    final BuildCardInputBoundary buildCardUseCaseInteractor;

    public BuildCardController(BuildCardInputBoundary buildCardUseCaseInteractor) {
        this.buildCardUseCaseInteractor = buildCardUseCaseInteractor;
    }
}
