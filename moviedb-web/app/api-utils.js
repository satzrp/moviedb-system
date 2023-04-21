const httpGet = async (url, revalidate = 60) => {
  const response = await fetch(url, {
    next: {
      revalidate,
    },
  });
  const data = await response.json();
  return data;
};

const httpPost = async (url, payload, token = null) => {
  const headers = {
    "Content-Type": "application/json",
    Accept: "application/json",
  };
  if (token) {
    headers["Authorization"] = `Bearer ${token}`;
  }
  try {
    const response = await fetch(url, {
      method: "POST",
      headers,
      body: JSON.stringify(payload),
    });
    return response;
  } catch (error) {
    console.error("Error: ", error);
  }
};

export { httpGet, httpPost };
