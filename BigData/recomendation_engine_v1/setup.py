#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""The setup script."""

from setuptools import setup, find_packages

with open('README.rst') as readme_file:
    readme = readme_file.read()

with open('HISTORY.rst') as history_file:
    history = history_file.read()

requirements = [
    'Click>=6.0',
    'numpy',
    'kafka',
    'pyspark',
    'pymongo'
]

setup_requirements = [
    # TODO(suryknt): setup requirements to be put here
]

test_requirements = [
    # TODO:  test requirements to be put here
]

setup(
    name='recomendation_engine_v1',
    version='0.1.0',
    description="This is the first version of the generic recommendation engine for retail applications",
    long_description=readme + '\n\n' + history,
    author="Suryakant Bhimraj Singh",
    author_email='suryknt@gmail.com',
    url='https://github.com/suryknt/recomendation_engine_v1',
    packages=find_packages(include=['recomendation_engine_v1']),
    entry_points={
        'console_scripts': [
            'recomendation_engine_v1=recomendation_engine_v1.cli:main'
        ]
    },
    include_package_data=True,
    install_requires=requirements,
    license="Apache Software License 2.0",
    zip_safe=False,
    keywords='recomendation_engine_v1',
    classifiers=[
        'Development Status :: 2 - Pre-Alpha',
        'Intended Audience :: Developers',
        'License :: OSI Approved :: Apache Software License',
        'Natural Language :: English',
        "Programming Language :: Python :: 2",
        'Programming Language :: Python :: 2.6',
        'Programming Language :: Python :: 2.7',
        'Programming Language :: Python :: 3',
        'Programming Language :: Python :: 3.3',
        'Programming Language :: Python :: 3.4',
        'Programming Language :: Python :: 3.5',
    ],
    test_suite='tests',
    tests_require=test_requirements,
    setup_requires=setup_requirements,
)
