import UserDetails from "./user-details";
import ReviewListByUser from "./review-list-by-user";
import { httpGet } from "@/app/api-utils";
import { API_URL } from "@/app/config";

async function fetchUserDetails(userId) {
  return await httpGet(`${API_URL}/users/${userId}`);
}

async function fetchReviewsByUser(userId) {
  return await httpGet(`${API_URL}/movies/reviews/${userId}`);
}

const UserPage = async ({ params: { userId } }) => {
  const userDetails = await fetchUserDetails(userId);
  const reviewsByUser = await fetchReviewsByUser(userId);
  return (
    <div className="row d-flex justify-content-center">
      <div className="col-md-9 col-lg-9">
        <UserDetails userDetails={userDetails} />
        <ReviewListByUser reviews={reviewsByUser} />
      </div>
    </div>
  );
};

export default UserPage;
