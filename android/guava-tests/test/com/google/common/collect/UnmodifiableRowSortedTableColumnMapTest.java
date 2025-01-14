/*
 * Copyright (C) 2008 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.collect;

import static com.google.common.collect.Tables.unmodifiableRowSortedTable;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.TableCollectionTest.ColumnMapTests;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public class UnmodifiableRowSortedTableColumnMapTest extends ColumnMapTests {
  public UnmodifiableRowSortedTableColumnMapTest() {
    super(false, false, false, false);
  }

  @Override
  Table<Integer, String, Character> makeTable() {
    RowSortedTable<Integer, String, Character> original = TreeBasedTable.create();
    return unmodifiableRowSortedTable(original);
  }

  @Override
  protected Map<String, Map<Integer, Character>> makePopulatedMap() {
    RowSortedTable<Integer, String, Character> table = TreeBasedTable.create();
    table.put(1, "foo", 'a');
    table.put(1, "bar", 'b');
    table.put(3, "foo", 'c');
    return unmodifiableRowSortedTable(table).columnMap();
  }
}
