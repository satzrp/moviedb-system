import Image from "next/image";
export const MovieCard = ({ movieId, movieName, movieDesc, avatarUrl }) => {
  console.log(movieId);
  return (
    <div class="col-md-4 mt-4">
      <div class="card profile-card">
        <div class="card-img-block">
          <a href="/movies/{movieId}">
            <Image width={100} height={100} class="card-img-top" src={avatarUrl} alt="" />
          </a>
        </div>
        <div class="card-body pt-0">
          <h5 class="card-title">{movieName}</h5>
          <p class="card-text">{movieDesc}</p>
        </div>
      </div>
    </div>
  );
};
