This program puts the user as CEO of their own Tech Company.
The users first task is to name the company. The rest is up to them and the board.

As a CEO, the user adheres to a board. The board assigns the CEO with objectives.
The CEO must meet the objectives or fail and lose the game.
The CEO also help from his CTO, CFO, HR, Lead Engineer, and some other employees.
The CEO can hire and fire employees, he can not fire board members.

The CEO will also have access to budgets and finances, employee progress reports, and other classified information.
The rest is up to you, the CEO....


Design of Game
- Use Composite/Factory Design pattern to label and track all employees in the company (ie. Using Hashmaps)
- Task Management will be designed as follows (Possible design will be a Hash of priority queues, but need to mess around with first):
	- Board gives CEO objectives
	- CEO must create tasks and delegate them to the team
	- Team must complete tasks before deadline
	- Board rating determines your success in the game
- CEO must approve new hires who can get tasks done quickly and efficiently 
- Each employee will strengths and weaknesses, this will play a big part in how fast tasks are finished and how well.

Overall game should not be too complicated :)