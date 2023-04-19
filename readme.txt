Usage Guide
To use the Rest API, you can send HTTP requests to the following endpoints:

POST /entercandidate?name={candidate_name} - to add a new candidate to the system. The name parameter should be the name of the candidate to be added.

POST /castvote?name={candidate_name} - to cast a vote for an existing candidate. The name parameter should be the name of the candidate to cast a vote for.

GET /countvote?name={candidate_name} - to get the vote count for an existing candidate. The name parameter should be the name of the candidate to get the vote count for.

GET /listvote - to get the list of all candidates and their vote counts.

GET /getwinner - to get the winner of the election.

All of the above API endpoints can be executed simultaneously by multi-users.

Features Implemented
The Rest API implements the following features:

Adding a new candidate with an initial vote count of 0.

Casting a vote for an existing candidate.

Getting the vote count for an existing candidate.

Getting the list of all candidates and their vote counts.

Getting the winner of the election based on the highest number of votes.

The API endpoints can be executed simultaneously by multi-users.

Unit tests have been implemented to test the functionality of the API endpoints.

