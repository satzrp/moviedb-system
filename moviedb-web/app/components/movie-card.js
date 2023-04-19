import Image from "next/image";
import Link from "next/link";

const MovieCard = ({ movieId, movieName, movieDesc, avatarUrl }) => {
  return (
    <div className="col-md-4 mt-4">
      <div className="card profile-card">
        <div className="card-img-block">
          <Link href={`/movies/${movieId}`}>
            <Image width={100} height={100} className="card-img-top" src={avatarUrl} alt="" />
          </Link>
        </div>
        <div className="card-body pt-0">
          <h5 className="card-title">{movieName}</h5>
          <p className="card-text">{movieDesc}</p>
        </div>
      </div>
    </div>
  );
};

export default MovieCard;
