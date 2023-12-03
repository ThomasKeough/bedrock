package app;

import interface_adapters.CollectionViewModel;
import interface_adapters.wonder_trade.WonderTradeController;
import interface_adapters.wonder_trade.WonderTradePresenter;
import use_cases.wonder_trade.WonderTradeInputBoundary;
import use_cases.wonder_trade.WonderTradeInteractor;
import use_cases.wonder_trade.WonderTradeOutputBoundary;
import use_cases.wonder_trade.WonderTradeDataAccessInterface;

import javax.swing.*;
import java.io.IOException;

public class WonderTradeUseCaseFactory {
    /** Prevent instantiation. */
    private WonderTradeUseCaseFactory() {}
        
    public static WonderTradeController createWonderTradeUseCase(CollectionViewModel collectionViewModel,
                                                                 WonderTradeDataAccessInterface wonderTradeDataAccessObject)
    {
        WonderTradeOutputBoundary wonderTradeOutputBoundary = new WonderTradePresenter(collectionViewModel);
        WonderTradeInputBoundary wonderTradeInteractor = new WonderTradeInteractor(wonderTradeOutputBoundary, wonderTradeDataAccessObject);

        return new WonderTradeController(wonderTradeInteractor);
        }
    }

