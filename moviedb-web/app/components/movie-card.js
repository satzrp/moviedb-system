import Image from "next/image";
export const MovieCard = ({ movieId, movieName, movieDesc, avatarUrl }) => {
  console.log(movieId);
  return (
    <div className="col-md-4 mt-4">
      <div className="card profile-card">
        <div className="card-img-block">
          <a href="/movies/{movieId}">
            <Image width={100} height={100} className="card-img-top" src={avatarUrl} alt="" />
          </a>
        </div>
        <div className="card-body pt-0">
          <h5 className="card-title">{movieName}</h5>
          <p className="card-text">{movieDesc}</p>
        </div>
      </div>
    </div>
  );
};
