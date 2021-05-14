//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Defines interactive qualities of entities, also optimizes the process of presenting entities to the player

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {

	private Handler handler;
	private Hero hero;
	private ArrayList<Entity> entities;
	// determines order in which assets render
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			} else {
				return 1;
			}
		}
	};

	public EntityManager(Handler handler, Hero hero) {
		this.handler = handler;
		this.hero = hero;
		entities = new ArrayList<Entity>();
		addEntity(hero);

	}

	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if (!e.isActive()) {
				it.remove();
			}
		}

		entities.sort(renderSorter);

	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}

	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	// GETTERS AND SETTERS
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
