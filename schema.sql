DROP TABLE IF EXISTS "movies";

CREATE TABLE "movies" (
  "id" SERIAL PRIMARY KEY,
  "name" TEXT NOT NULL,
  "year_of_release" INTEGER NOT NULL,
  "description" TEXT NOT NULL,
  "running_length" INTEGER NOT NULL,
  "genre" TEXT NOT NULL,
  "avatar" TEXT NOT NULL,
  "image_url" TEXT NOT NULL,
  "actors" TEXT NOT NULL,
  "director" TEXT NOT NULL,
  "created_at" TIMESTAMP DEFAULT NOW(),
  "updated_at" TIMESTAMP DEFAULT NOW()
);

DROP TABLE IF EXISTS "users";

CREATE TABLE "users" (
  "id" SERIAL PRIMARY KEY,
  "email" TEXT NOT NULL,
  "password" TEXT NOT NULL,
  "name" TEXT NOT NULL,
  "role" TEXT NOT NULL,
  "created_at" TIMESTAMP DEFAULT NOW(),
  "updated_at" TIMESTAMP DEFAULT NOW()
);

DROP TABLE IF EXISTS "reviews";

CREATE TABLE "reviews" (
  "id" SERIAL PRIMARY KEY,
  "movie_id" INTEGER NOT NULL,
  "user_id" INTEGER NOT NULL,
  "review_content" TEXT NOT NULL,
  "created_at" TIMESTAMP DEFAULT NOW(),
  "updated_at" TIMESTAMP DEFAULT NOW(),
  FOREIGN KEY(movie_id) REFERENCES movies(id),
  FOREIGN KEY(user_id) REFERENCES users(id)
);

INSERT INTO "movies" ("name", "year_of_release", "description", "running_length", "genre", "avatar", "image_url", "actors", "director") VALUES
('The Shawshank Redemption', '1994', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', '142', 'Crime, Drama', '/images/thumbnails/1.jpg', '/images/media/1.jpg', 'Tim Robbins, Morgan Freeman', 'Frank Darabont'),
('The Godfather', '1972', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', '175', 'Crime, Drama', '/images/thumbnails/2.jpg', '/images/media/2.jpg', 'Marlon Brando, Al Pacino', 'Francis Ford Coppola'),
('The Godfather: Part II', '1974', 'The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, expands and tightens his grip on the family crime syndicate.', '202', 'Crime, Drama', '/images/thumbnails/3.jpg', '/images/media/3.jpg', 'Al Pacino, Robert De Niro', 'Francis Ford Coppola'),
('The Dark Knight', '2008', 'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.', '152', 'Action, Crime, Drama, Thriller', '/images/thumbnails/4.jpg', '/images/media/4.jpg', 'Christian Bale, Heath Ledger', 'Christopher Nolan'),
('12 Angry Men', '1957', 'A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.', '96', 'Crime, Drama', '/images/thumbnails/5.jpg', '/images/media/5.jpg', 'Henry Fonda, Lee J. Cobb', 'Sidney Lumet'),
('Pulp Fiction', '1994', 'The lives of two mob hit men, a boxer, a gangster''s wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', '154', 'Crime, Drama', '/images/thumbnails/6.jpeg', '/images/media/6.jpg', 'John Travolta, Uma Thurman, Samuel L. Jackson', 'Quentin Tarantino');
