//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Will define the main menu

import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);

		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(200, 200, 90, 90, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {

		uiManager.render(g);
	}

}
