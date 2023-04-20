import Image from "next/image";

const UserDetails = ({ userDetails: { name, email } }) => {
  return (
    <div className="text-center">
      <div className="user-profile">
        <Image src={"/avatar.png"} className="rounded-circle" width={50} height={50} alt="" />
      </div>
      <div className="mt-3 text-center">
        <h4 className="mb-2 fs-3 text-special text-dark">{name}</h4>
        <span className="d-block fs-5 text-special text-dark mb-5">{email}</span>
      </div>
    </div>
  );
};

export default UserDetails;
