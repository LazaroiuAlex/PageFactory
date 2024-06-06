package tests;

public class GitResetCommands {
	
	/*
	 * 1. Reset files from staging area; git reset (muta toate fisierele din staging inapoi in working directory)
	 * 2. reset single file from staging area: git reset <calea>
	 * 3. reset a commit: git reset HEAD^ sau multiple commits: git reset HEAD^~2
	 * git reset flags: 
	 * git reset --soft (sterge comitul din istoric si muta fisierele in staging area)
	 * git reset --mixed (sterge comitul din istoric si muta fisierele in working directory)
	 * git reeset --hard (sterge comitul din istoric si fisierele)
	 * 4. delete a commit from remote repo
	 * delete commit from local: git reset HEAD^
	 * push the change to remote which will delete the commit also from: git push origin +HEAD
	 * 5. delete commit from remote only(keep on local)
	 * git push origin +HEAD^:master
	 */

}
