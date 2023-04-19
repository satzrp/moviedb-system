import Image from "next/image";
import { BASE_URL } from "@/app/config";
import MovieMetadata from "@/app/components/movie-metadata";

const MovieDetail = ({ movieDetails }) => {
  const metadata = {
    releaseYear: movieDetails.yearOfRelease,
    movieLength: movieDetails.runningLength,
    genre: movieDetails.genre,
    actors: movieDetails.actors,
    director: movieDetails.director,
  };
  return (
    <div className="movie-detail mb-4">
      <div className="text-center">
        <Image width={500} height={500} className="img-fluid" src={`${BASE_URL}${movieDetails.imageUrl}`} alt="..." />
        <h5 className="card-title mt-4">{movieDetails.name}</h5>
        <p className="card-text">{movieDetails.description}</p>
        <MovieMetadata metadata={metadata} />
      </div>
    </div>
  );
};

export default MovieDetail;
