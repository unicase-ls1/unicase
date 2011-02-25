package org.unicase.ui.tom.touches;


/**
 * @author schroech
 *
 */
public abstract class AbstractTouch implements Touch {

	private MultiTouch multiTouch;

	public void setMultiTouch(MultiTouch multiTouch) {
		this.multiTouch = multiTouch;
	}

	public MultiTouch getMultiTouch() {
		return multiTouch;
	}

	public long getLifeSpan() {

		long downTime = getTouchDownDate().getTime();
		long upTime = getTouchUpDate().getTime();

		return upTime - downTime;
	}


}
