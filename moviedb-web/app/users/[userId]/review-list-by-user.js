import ReviewWithMovieDetails from "./review-with-movie-details";

const ReviewListByUser = ({ reviews }) => {
  return (
    <div className="user-reviews">
      {reviews.map((review) => (
        <ReviewWithMovieDetails key={review.id} review={review} />
      ))}
    </div>
  );
};

export default ReviewListByUser;
