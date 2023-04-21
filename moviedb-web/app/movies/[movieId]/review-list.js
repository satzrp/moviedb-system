import Review from "./review";

// TODO: update component when new review is posted
const ReviewList = ({ reviews }) => {
  return (
    <div className="card text-dark my-4">
      <h4 className="my-3 mx-3">Recent comments</h4>
      <p className="fw-light mb-4 mx-3 pb-2">Latest Comments section by users</p>
      {reviews.map((review) => (
        <Review key={review.id} review={review} />
      ))}
    </div>
  );
};

export default ReviewList;
