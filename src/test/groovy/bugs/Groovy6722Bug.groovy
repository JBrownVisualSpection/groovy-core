/*
 * Copyright 2003-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package groovy.bugs

class Groovy6722Bug extends GroovyTestCase {
    void testThatCompilerRecognizesCovariantArray() {
        assertScript '''
abstract class Top<Elem,Result> {
    abstract Result exec(Elem... elems)
}

class Bottom extends Top<Integer, String> {
    @Override
    String exec(Integer... elems) {
        "$elems"
    }
}
def b = new Bottom()
assert b.exec(4,5,6) == "[4, 5, 6]"
'''
    }
}