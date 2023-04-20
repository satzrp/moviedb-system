import Image from "next/image";
import Link from "next/link";
import { BASE_URL } from "@/app/config";

const ReviewWithMovieDetails = ({ review }) => {
  return (
    <div className="card border-0 mb-2 p-2 mx-2 mt-2">
      <div className="row g-0">
        <div className="col-md-3">
          <Image
            src={`${BASE_URL}${review.movie.avatarUrl}`}
            height={300}
            width={150}
            className="img-fluid rounded-start"
            alt=""
          />
        </div>
        <div className="col-md-9">
          <div className="card-body">
            <h5 className="card-title">
              <Link className="name-link" href={`/movies/${review.movie.id}`}>
                {review.movie.name}
              </Link>
            </h5>
            <p className="card-text">{review.reviewContent}</p>
            <p className="card-text">
              <small className="text-muted">Posted on: {new Date(review.createdAt).toDateString()}</small>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ReviewWithMovieDetails;
