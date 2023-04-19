import MovieDetail from "./movie-detail";
import ReviewList from "./review-list";

const data = {
  movieDetails: {
    id: 1,
    name: "The Shawshank Redemption",
    yearOfRelease: 1994,
    description:
      "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
    runningLength: 142,
    genre: "Crime, Drama",
    avatarUrl: "/images/thumbnails/1.jpg",
    imageUrl: "/images/media/1.jpg",
    actors: "Tim Robbins, Morgan Freeman",
    director: "Frank Darabont",
  },
  reviews: [
    {
      user: {
        id: 1,
        name: "Sathish Kumar",
        email: "sathish@moviedb.com",
      },
      id: 1,
      reviewContent:
        "Why do I want to write the 234th comment on The Shawshank Redemption? I am not sure - almost everything that could be possibly said about it has been said. But like so many other people who wrote comments, I was and am profoundly moved by this simple and eloquent depiction of hope and friendship and redemption.",
      createdAt: "2023-03-24T12:53:59.819629",
    },
  ],
};

const MovieDetailPage = () => {
  return (
    <section>
      <div className="mt-5 pb-5 text-dark">
        <div className="row d-flex justify-content-center">
          <div className="col-md-10 col-lg-10">
            <MovieDetail movieDetails={data.movieDetails} />
            <ReviewList reviews={data.reviews} />
          </div>
        </div>
      </div>
    </section>
  );
};

export default MovieDetailPage;
