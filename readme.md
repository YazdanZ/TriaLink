![preview](https://github.com/YazdanZ/McHacks/blob/main/Pics/website.png)

## Inspiration
We got the idea when we ask ourselves the question: how can we better make use of the large amounts of data in the world to meet people's privacy and healthcare needs? We all recall being at the doctor's office and seeing the doctor write long written notes. We then came up with a potentially impactful idea that is rewarding to create, both conceptually and technically.


## What it does
Imagine your research has finally reached the stage of clinical trials. Finding the right participants meeting the strict trial criteria (specific combinations of illnesses, prescription drugs, medical devices, surgical history, and anatomy) is paramount to a successful trial. 

Current researchers have to manually search through many medical notes to identify their potential candidates. Doctors already write medical notes to a centralized repository, but unstructured data is not useful on its own. TrialLink uses privacy-minded natural language processing to extract medical information from unstructured medical notes. We offer researchers a platform to perform advanced queries to easily find candidates for medical trials that exactly match their strict requirements.  

Our platform uses HIPPA-compliant technologies. It allows participants who have previously consented to participate in clinical trials to receive timely notifications when they are matched to a trial. We also implemented a proxy server to securely route our API calls. 


## How we built it
Our final application involved the integration of database tables, Velo code, Java Spring backend, Google Cloud API, Javascript, and CSS. 

## Challenges we ran into
Using the enterprise version of Google Cloud has a high overhead and required an understanding of different security models. 
The database schemas and querying functions were complex. 

## Accomplishments that we're proud of

We are proud of using NLP in creative ways to make use of information from a preexisting abundant source of unstructured notes to improve access to healthcare for patients and assist researchers by minimizing their time looking for appropriate trial candidates. 

## What's next for TrialLink
Add more querying options. 
Connect to existing databases of medical notes.
Make it a startup!


We will add the website and db code to this repo very soon.
