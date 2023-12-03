package interface_adapters.game;

import entities.Game;
import interface_adapters.ViewManagerModel;
import interface_adapters.WinViewModel;
import use_cases.game.GameOutputBoundary;
import use_cases.game.GameOutputData;
import view.WinView;

public class GamePresenter implements GameOutputBoundary {

    private final GameViewModel gameViewModel;
    private final WinViewModel winViewModel;
    private ViewManagerModel viewManagerModel;

    public GamePresenter(ViewManagerModel viewManagerModel,
                           WinViewModel winViewModel,
                           GameViewModel gameViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.gameViewModel = gameViewModel;
        this.winViewModel = winViewModel;
    }
    @Override
    public void prepareSuccessView(GameOutputData winner) {
        viewManagerModel.setActiveView(winViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
