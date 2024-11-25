function checkMail() {
    const mailReceived = Math.random() > 0.5; // Simulate mail receipt
    return new Promise((resolve, reject) => {
      if (mailReceived) {
        resolve("Mail received!");
      } else {
        reject("No mail received.");
      }
    });
  }
  
  checkMail()
    .then((message) => {
      console.log("Success:", message);
    })
    .catch((error) => {
      console.error("Caught an error:", error);
    })
    .finally(() => {
      console.log("Execution completed.");
    });
  