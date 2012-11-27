package se.softhouse.dirty.git;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class GitTest
{
	@Test
	public void testGitCommands()
	{
		Git git = new Git();
		String response = git.doCommand("status");
		assertThat(response).startsWith("Status for:");

		response = git.doCommand("commit");
		assertThat(response).startsWith("Committed:");

		response = git.doCommand("log");
		assertThat(response).startsWith("Log for:");

		response = git.doCommand("diff");
		assertThat(response).startsWith("Diff between:");

		try
		{
			response = git.doCommand("cleanCode");
			fail("git should not support cleanCode?");
		}
		catch (UnsupportedOperationException expected)
		{

		}
	}
}
