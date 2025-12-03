const start = document.getElementById("startDate").value;
const end = document.getElementById("endDate").value;

document.getElementById("outStart").innerText = start || "____ / ____ / ______";
document.getElementById("outEnd").innerText = end || "____ / ____ / ______";

function fillContract() {

    const name = document.getElementById("empName").value;
    const position = document.getElementById("empPosition").value;
    const salary = document.getElementById("empSalary").value;
    const dateA = document.getElementById("empDateA").value;
    const dateB = document.getElementById("empDateB").value;
    
    const start = document.getElementById("startDate").value;
    const end = document.getElementById("endDate").value;

    document.getElementById("outName").innerText = name || "________________________________________";
    document.getElementById("outSigName").innerText = name || "______________________________";
    document.getElementById("outPosition").innerText = position || "____________________________________________";
    document.getElementById("outSalary").innerText = salary || "___________";

    document.getElementById("outDateA").innerText = dateA || "____ / ____ / ______";
    document.getElementById("outDateB").innerText = dateB || "____ / ____ / ______";

    document.getElementById("outStart").innerText = start || "____ / ____ / ______";
    document.getElementById("outEnd").innerText = end || "____ / ____ / ______";
}
document.getElementById("fillBtn").addEventListener("click", function () {

  const name     = document.getElementById("empName").value.trim();
  const position = document.getElementById("empPosition").value.trim();
  const salary   = document.getElementById("empSalary").value.trim();
  const start    = document.getElementById("startDate").value;
  const end      = document.getElementById("endDate").value;
  const dateA    = document.getElementById("empDateA").value;
  const dateB    = document.getElementById("empDateB").value;

  // Write contract
  document.getElementById("outName").innerText = name || "________________________________________";
  document.getElementById("outSigName").innerText = name || "______________________________";
  document.getElementById("outPosition").innerText = position || "____________________________________________";
  document.getElementById("outSalary").innerText = salary || "___________";

  document.getElementById("outStart").innerText = formatForContract(start);
  document.getElementById("outEnd").innerText = formatForContract(end);
  document.getElementById("outDateA").innerText = formatForContract(dateA);
  document.getElementById("outDateB").innerText = formatForContract(dateB);
  

  // Build result
  const resultsBox = document.getElementById("resultsBox");
  resultsBox.style.display = "block";
  resultsBox.innerText =
`Employment Contract

Employer (Party A): Schroder Quantitative Technology Co., Ltd.
Employee (Party B): ${name || "N/A"}
Position: ${position || "N/A"}
Monthly Salary: USD ${salary || "N/A"}
Term: ${formatForContract(start)} to ${formatForContract(end)}
Employer Signature Date: ${formatForContract(dateA)}
Employee Signature Date: ${formatForContract(dateB)}`;

  // Copy button
  const copyBtn = document.getElementById("copyBtn");
  copyBtn.style.display = "inline-block";
  copyBtn.onclick = function () {
    navigator.clipboard.writeText(resultsBox.innerText).then(() => {
      alert("Contract copied to clipboard.");
    });
  };

  // ⭐⭐⭐ FIXED — WORKS 100% ⭐⭐⭐
  setTimeout(() => {
    resultsBox.scrollIntoView({ behavior: "smooth", block: "start" });
  }, 200);

});
