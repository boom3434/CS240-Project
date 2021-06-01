package platformer.states;

import java.awt.Graphics;

import platformer.Handler;
import platformer.gfx.Assets;
import platformer.ui.ClickListener;
import platformer.ui.UIImageButton;
import platformer.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(300, 200, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
		
	
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
