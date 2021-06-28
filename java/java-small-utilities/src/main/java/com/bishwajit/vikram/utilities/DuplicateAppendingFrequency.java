package com.bishwajit.vikram.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.sun.xml.internal.bind.v2.runtime.NameList;

/**
 * 
 * @author Bishwajit
 *
 */
public class DuplicateAppendingFrequency {

	public static void main(String[] args) {
		DuplicateAppendingFrequency duplicateAppendingFrequency = new DuplicateAppendingFrequency();
		List<Project> projectList = duplicateAppendingFrequency.prepareProjectList();
		Set<Project> sortedProjectSet = new TreeSet<>((o1, o2) -> o2.getId().compareTo(o1.getId()));
		Map<String, List<Project>> mapDuplicates = new HashMap<>();
		List<Project> finalProjectList = new ArrayList<>();

		sortedProjectSet.addAll(projectList);
		sortedProjectSet.stream().forEach(project -> {
			if (null != project.getName()) {
				List<Project> nameList = new ArrayList<>();
				if (null != mapDuplicates.get(project.getName())) {
					nameList = mapDuplicates.get(project.getName());
					project.setDuplicate(nameList.size());
				}
				nameList.add(project);
				mapDuplicates.put(project.getName(), nameList);
			} else {
				finalProjectList.add(project);
			}
		});
		mapDuplicates.values().stream().forEach(finalProjectList::addAll);
		finalProjectList.stream().forEach(System.out::println);
	}

	public List prepareProjectList() {
		List<Project> projectList = new ArrayList<>();
		projectList.add(new Project(UUID.randomUUID().toString(), "Bishwajit"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Vikram"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Bishwajit"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Vikram"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Bishwajit"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Bishwajit"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Bishwajit"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Bishwajit"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Vikram"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Bishwajit"));
		projectList.add(new Project(UUID.randomUUID().toString(), "Chhotu"));
		return projectList;
	}

	class Project {

		private String id;
		private String name;
		private int duplicate;

		public Project(String id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getDuplicate() {
			return duplicate;
		}

		public void setDuplicate(int duplicate) {
			this.duplicate = duplicate;
		}

		@Override
		public String toString() {
			return "Project [id=" + id + ", name=" + name + ", duplicate=" + duplicate + "]";
		}

	}
}
