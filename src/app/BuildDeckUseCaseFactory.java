package app;

import interface_adapters.ViewManagerModel;
import interface_adapters.build_deck.BuildDeckController;
import interface_adapters.build_deck.BuildDeckPresenter;
import interface_adapters.build_deck.BuildDeckViewModel;
import use_cases.build_deck.BuildDeckInputBoundary;
import use_cases.build_deck.BuildDeckInputData;
import use_cases.build_deck.BuildDeckInteractor;
import use_cases.build_deck.BuildDeckOutputBoundary;
import view.BuildDeckView;

public class BuildDeckUseCaseFactory {
    private BuildDeckUseCaseFactory() {}

    public static BuildDeckView create(ViewManagerModel viewManagerModel, BuildDeckViewModel buildDeckViewModel) {
        BuildDeckController buildDeckController = createBuildDeckUseCase(buildDeckViewModel);
        return new BuildDeckView(buildDeckViewModel, viewManagerModel, buildDeckController);
    }

    public static BuildDeckController createBuildDeckUseCase(BuildDeckViewModel buildDeckViewModel) {
        BuildDeckOutputBoundary buildDeckPresenter = new BuildDeckPresenter(buildDeckViewModel);
        BuildDeckInputBoundary buildDeckInteractor = new BuildDeckInteractor(buildDeckPresenter);
        return new BuildDeckController(buildDeckInteractor);
    }
}
