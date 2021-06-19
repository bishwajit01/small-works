package com.bishwajit.vikram.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @author Bishwajit
 *
 */
public class DeleteIfItExistMoreThanLimit {

	public static final int LIMIT = 2;

	public static void main(String[] args) {
		DeleteIfItExistMoreThanLimit object = new DeleteIfItExistMoreThanLimit();
		List<SampleA> sampleAList = object.createSampleList();

		System.out.println(":::::::::Value before Deleting:::::::::::");
		sampleAList.stream().forEach(System.out::println);
		System.out.println();

		// deleting all elements if it exist LIMIT
		removeElements(sampleAList);

		System.out.println(":::::::::Value after Deleting:::::::::::");
		sampleAList.stream().forEach(System.out::println);
	}

	private static void removeElements(List<SampleA> sampleAList) {
		if (null != sampleAList && !sampleAList.isEmpty()) {
			
			// sort the list on time stamp in descending order
			sortingList(sampleAList);
			System.out.println(":::::::::Value after Sorting:::::::::::");
			sampleAList.stream().forEach(System.out::println);
			System.out.println();
			
			while (LIMIT < sampleAList.size()) {
				sampleAList.remove(sampleAList.size() - 1);
			}
		}
	}

	private static void sortingList(List<SampleA> sampleAList) {
		Collections.sort(sampleAList, Comparator.comparingLong(SampleA::getCreatedTime).reversed());
	}

	private List<SampleA> createSampleList() {
		List<SampleA> sampleAList = new ArrayList<>();
		sampleAList.add(createSampleA("A", 10));
		sampleAList.add(createSampleA("B", 20));
		sampleAList.add(createSampleA("C", 30));
		sampleAList.add(createSampleA("D", 40));
		sampleAList.add(createSampleA("E", 50));

		return sampleAList;
	}

	private SampleA createSampleA(String name, int age) {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.err.println("ERRORRRR");
		}
		return new SampleA(UUID.randomUUID().toString(), name, age, new Date().getTime());
	}

	private class SampleA {

		private String id;
		private String name;
		private int age;
		private long createdTime;

		public SampleA(String id, String name, int age, long createdTime) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.createdTime = createdTime;
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

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public long getCreatedTime() {
			return createdTime;
		}

		public void setCreatedTime(long createdTime) {
			this.createdTime = createdTime;
		}

		@Override
		public String toString() {
			return "SampleA [id=" + id + ", name=" + name + ", age=" + age + ", createdTime=" + createdTime + "]";
		}
	}
}
