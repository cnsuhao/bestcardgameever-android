package com.sheepzkeen.yaniv;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Descendant of the Hand class @see {@link Hand}
 * This is a hand that is controlled by artificial intelligence.
 * @author Elad
 *
 */
public class OpponentHand extends Hand {

	private YanivStrategy strategy;

	public OpponentHand(YanivStrategy strategy, View container, ImageView[] cards, TextView name) {
		super(container,cards,name);
		//start the game with cards hidden
		setShouldCardsBeShown(false);
		this.strategy = strategy;
	}


	@Override
	public void pickup(PlayingCard card) {
		if(card != null){
			addCard(card);
		}else{
			//no card given, need to decide which card to pickup
		}
		// TODO AI

	}


	@Override
	protected void selectCardsToDrop() {
		//TODO:AI
		//here the hand needs to decide what to do - which card to drop - highest value X (series, sameVal or card)
		strategy.decideDrop(cards);
	}

	@Override
	public boolean isAwaitingInput() {
		return false;
	}
}
