const httpGet = async (url) => {
  const response = await fetch(url, {
    next: {
      revalidate: 60,
    },
  });
  const data = await response.json();
  return data;
};

export { httpGet };
