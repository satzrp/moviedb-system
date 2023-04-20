import MovieDetail from "./movie-detail";
import ReviewList from "./review-list";
import { httpGet } from "@/app/api-utils";
import { API_URL } from "@/app/config";

async function fetchMovie(movieId) {
  return await httpGet(`${API_URL}/movies/${movieId}`);
}

const MovieDetailPage = async ({ params: { movieId } }) => {
  const movie = await fetchMovie(movieId);
  return (
    <section>
      <div className="mt-5 pb-5 text-dark">
        <div className="row d-flex justify-content-center">
          <div className="col-md-9 col-lg-9">
            <MovieDetail movieDetails={movie.movieDetails} />
            <ReviewList reviews={movie.reviews} />
          </div>
        </div>
      </div>
    </section>
  );
};

export default MovieDetailPage;
