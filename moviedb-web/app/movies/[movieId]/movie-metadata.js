const MovieMetadata = ({ metadata: { releaseYear, movieLength, genre, actors, director } }) => {
  return (
    <ul className="list-unstyled">
      <li>Release Year: {releaseYear}</li>
      <li>Movie Length: {movieLength} mins</li>
      <li>Genre: {genre}</li>
      <li>Actors: {actors}</li>
      <li>Director: {director}</li>
    </ul>
  );
};

export default MovieMetadata;
