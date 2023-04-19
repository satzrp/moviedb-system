import Image from "next/image";
import Link from "next/link";

const Review = ({ review }) => {
  const { user, reviewContent, createdAt } = review;
  const { id: userId, name, email } = user;
  return (
    <>
      <div className="card-body p-4">
        <div className="d-flex flex-start">
          <Image
            className="rounded-circle shadow-1-strong me-3"
            src={"/avatar.png"}
            alt="avatar"
            width={40}
            height={40}
          />
          <div>
            <h6 className="fw-bold mb-1">
              <Link className="name-link" href={`/users/${userId}`}>
                {name}
              </Link>
            </h6>
            <div className="d-flex align-items-center mb-3">
              <p className="mb-0 fw-light">
                {email} (posted on {new Date(createdAt).toDateString()})
              </p>
            </div>
            <p className="mb-0">{reviewContent}</p>
          </div>
        </div>
      </div>
      <hr className="my-0" />
    </>
  );
};

export default Review;
