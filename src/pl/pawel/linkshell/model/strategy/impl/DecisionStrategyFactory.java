package pl.pawel.linkshell.model.strategy.impl;

import pl.pawel.linkshell.model.enums.strategy.DecisionStrategyType;
import pl.pawel.linkshell.model.strategy.DecisionStrategy;

/**
 * Created by pawellinkshell on 11.02.2018.
 */
public class DecisionStrategyFactory {
    public static DecisionStrategy getStrategy(DecisionStrategyType strategyType) {
        switch (strategyType) {
            case PLAYER_LIVE:
                return GamblerDecisionStrategy.getInstance();
            case PLAYER_AI_DEFAULT:
                return DefaultDealerDecisionStrategy.getInstance();
            default:
                return NullDecisionStrategy.getInstance();
        }
    }
}
