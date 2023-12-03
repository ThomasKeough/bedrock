package app;

import interface_adapters.DecksViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.build_deck.BuildDeckViewModel;
import interface_adapters.delete_deck.DeleteDeckController;
import interface_adapters.delete_deck.DeleteDeckPresenter;
import interface_adapters.delete_deck.DeleteDeckViewModel;
import use_cases.delete_deck.DeleteDeckInputBoundary;
import use_cases.delete_deck.DeleteDeckInteractor;
import use_cases.delete_deck.DeleteDeckOutputBoundary;
import view.DecksView;

import javax.swing.*;
import java.io.IOException;

public class DeckUseCaseFactory {
    private DeckUseCaseFactory() {}

    public static DecksView create(ViewManagerModel viewManagerModel, DecksViewModel decksViewModel,
                                   DeleteDeckViewModel deleteDeckViewModel, BuildDeckViewModel buildDeckViewModel) {
        DeleteDeckController signupController = createDeleteDeckUseCase(deleteDeckViewModel);
        return new DecksView(signupController, decksViewModel, deleteDeckViewModel, buildDeckViewModel, viewManagerModel);
    }

    private static DeleteDeckController createDeleteDeckUseCase(DeleteDeckViewModel deleteDeckViewModel) {
        DeleteDeckOutputBoundary deleteDeckPresenter = new DeleteDeckPresenter(deleteDeckViewModel);
        DeleteDeckInputBoundary deleteDeckInteractor = new DeleteDeckInteractor(deleteDeckPresenter);
        return new DeleteDeckController(deleteDeckInteractor);
    }
}
